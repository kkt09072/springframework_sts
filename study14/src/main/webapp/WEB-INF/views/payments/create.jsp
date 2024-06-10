<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>결제하기</title>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="full-wrap">
    <main id="contents" class="contents">
    	<h2 class="page-title">상품 구매</h2>
    	<hr>
   		<div class="page-wrap">
    		<div class="clr-fix">
    			<br>
				<form action="${path2 }/payments/create" method="post">
					<table class="table" id="tb1">
						<tbody>
							<tr>
								<th><h3>제품 정보</h3></th>
								<td>
									<div class="item_fr">
										<input type="hidden" name="pno" id="pno" value="${pno }" />
										<input type="hidden" id="name" value="${cus.name }" />
										<input type="hidden" id="pname" value="${pname }" /> 
										<input type="hidden" name="userId" id="id" value="${cid }" />
										<input type="hidden" id="email" value="${cus.email }" />
										<input type="hidden" id="custel" value="${cus.tel }" />
										<input type="hidden" id="cusaddr" value="${cus.addr1 }" />
										<input type="hidden" id="cusaddr2" value="${cus.addr2 }" />
										<input type="hidden" id="cuspostcode" value="${cus.postcode }" />
										<input type="hidden" name="gtid" id="gtid" />
										<input type="hidden" name="paymentId" id="paymentId" value="${paymentId }" />
										<input type="hidden" name="status" id="status" value="before" />
										<input type="hidden" name="impUid" id="impUid" value="${code}" />
										<input type="hidden" name="merchantUid" id="merchantUid" />
										<h4>제품명 : ${pname }</h4>
										<br>
										<h4>제품 설명</h4>
										<p>${com }</p>
									</div>
								</td>
							</tr>
							<tr>
								<th><h3>구매 정보</h3></th>
								<td>
									<div class="item_fr">
										<strong>단가 </strong> : 
										<input type="number" id="price" value="${oprice }" class="input" style="display:inline-block; width:85%;" readonly /><br>
										<strong>수량 </strong> : 
										<c:if test="${cnt gt 0}">
											<input type="number" name="cnt" id="cnt" min="1" max="${cnt }" step="1" class="input" style="display:inline-block; width:85%;" required />
										</c:if>
										<c:if test="${(cnt eq 0) or (cnt lt 1)}">
											<strong style="color:red">품절</strong>
										</c:if>
										<br>
									</div>
								</td>
							</tr>
							<c:if test="${cnt gt 0}">
							<tr class="change_item">
								<th><h3>결제 정보</h3></th>
								<td>
									<div class="item_fr">
										<strong>결제할 금액</strong> : 
										<input type="number" name="amount" id="amount" class="input" style="display:inline-block; width:85%;" required />											
									</div>
									<div class="item_fr">
										<strong>결제 버튼을 누르세요</strong>
										<input type="hidden" name="paymethod" id="paymethod" />
										<input type="hidden" name="paynum" id="paynum" />
										<input type="hidden" name="gtid" id="gtid" />
									</div>
									<button type="button" id="payBtn" class="button is-danger">결제</button>
									<br>
									<div id="msg">
										
										
									</div>
								</td>
							</tr>
							</c:if>
							<c:if test="${amount gt 0}">
							<tr class="result_item">
								<th><h3>배송 정보</h3></th>
								<td>
									<div class="item_fr">
										<strong>주문자</strong> :
										<strong>${cus.name }</strong> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
										<input type="checkbox" id="ck2">
										<label for="ck2">주문자와 수신자가 동일합니다.</label>											
									</div>
									<div class="item_fr">
										<strong>수신자</strong> :
										<input type="text" name="rname" id="rname" class="input" required /> 											
									</div>
									<div class="item_fr">
										<h4>배송지</h4>
										<hr>
										<strong>기본 주소</strong> : <input type="text" name="addr1" id="addr1" class="input" style="display:inline-block; width:85%;" required><br> 
										<strong>상세 주소</strong> : <input type="text" name="addr2" id="addr2" class="input" style="display:inline-block; width:85%;" required><br>
										<strong>상세 주소</strong> : <input type="text" name="postcode" id="postcode" class="input" style="display:inline-block; width:85%;" required><br><br>
										<input type="button" id="isAddrBtn" class="button is-link" value="주소 입력" onclick="findAddr()">
										<input type="hidden" name="addr" id="addr" />											
									</div>
									<div class="item_fr">
										<strong>연락처</strong> :
										<input type="tel" name="tel" id="tel" class="input" required><br> 
									</div>
								</td>
							</tr>
							</c:if>
						</tbody>
					</table>
					<hr>
					<div class="buttons">
					  <button type="submit" class="button is-danger" id="salesBtn">구매</button>
					</div>
				</form>
	            <script>
                function findAddr() {
                    new daum.Postcode({
                        oncomplete: function(data) {
                            console.log(data);
                            var roadAddr = data.roadAddress;
                            var jibunAddr = data.jibunAddress;
                            document.getElementById("postcode").value = data.zonecode;
                            if(roadAddr !== '') {
                                document.getElementById("addr1").value = roadAddr;
                            } else if(jibunAddr !== ''){
                                document.getElementById("addr1").value = jibunAddr;
                            }
                            document.getElementById("addr2").focus();
                        }
                    }).open();
                }
            	</script>
            	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				
				<!-- 결제 API -->
				<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
				<script>
				$(document).ready(function(){
					
					$("#addr2").focusout(function(){
						$("#addr").val($("#addr1").val()+"   "+$("#addr2").val()+"   "+$("#postcode").val());
					});
					
					$(".change_item").css("display", "none");
					$(".result_item").css("display", "none");
					$("#salesBtn").css("display", "none");
					
					$("#cnt").on("change", function(){
						$("#amount").val(parseInt($("#price").val())*parseInt($("#cnt").val()));
						$(".change_item").css("display", "");	
					});
					
					$("#cnt").on("keyup", function(){
						$("#amount").val(parseInt($("#price").val())*parseInt($("#cnt").val()));
						$(".change_item").css("display", "");	
					});
					
					$("#payBtn").click(function(){
						var money = parseInt($("#amount").val());
						var code = `${code}`;
						var merchantUid = 'merchant_' + new Date().getTime();
						console.log("결제");
				        IMP.init(code); // 가맹점 식별코드로 Iamport 초기화
				        IMP.request_pay({ // 결제 요청
				            pg: "danal_tpay",   // PG사 설정
				            pay_method: "card", // 결제 방법
				            merchant_uid: merchantUid, // 주문 번호
				            name: $("#pname").val(), // 상품 이름
				            amount: money, // 결제 가격
				            buyer_email: $("#email").val(),
				            buyer_name: $("#name").val(), // 구매자 이름 (buyer_ 부분은 꼭 작성하지 않아도된다. (선택사항))
				            buyer_tel: $("#custel").val(), // 구매자 연락처
				            buyer_postcode: $("#cuspostcode").val(), // 구매자 우편번호
				            buyer_addr: $("#cusaddr").val() // 구매자 주소
				        }, function(rsp){
				        	
				        	var gt_id = "12345678";	//거래 승인 번호
				        	var card_name = "삼성카드";
				        	var card_number = "1234567890123";
				        	var pay_method = "card";
				        	var amount = money;
				        	
				        	if (rsp.success) {
				        		//결제 성공시 처리하는 구문들
					        	gt_id = rsp.apply_num;
					        	pay_method = rsp.pay_method;
					        	
					        	console.log('PG사 구분코드 : ' + rsp.pg_provider);
					        	console.log('고유ID : ' + rsp.imp_uid);
					        	console.log('상점 거래ID : ' + rsp.merchant_uid);
					        	console.log('결제 수단 : ' + rsp.pay_method);
					        	console.log('결제 금액 : ' + rsp.paid_amount);
					        	console.log('거래 매출전표 URL : ' + rsp.receipt_url);
					        	console.log('결제 통화 : '+rsp.currency);
					        	console.log('거래 승인번호 : ' + rsp.apply_num);
					        	
					        	if(rsp.pay_method=='card') { //카드인 경우
					        		console.log('신용 카드 이름 : ' + rsp.card_name);
					        		console.log('신용 카드 번호 : ' + rsp.card_number);
						        	card_name = rsp.card_name;
						        	card_number = rsp.card_number;
					        	}
					        	
					        	if(rsp.pay_method=='vbank') { //가상 계좌인 경우
						        	console.log('가상계좌 입금 계좌번호 : ' + rsp.vbank_num);
						        	console.log('가상계좌 입금 은행명 : ' + rsp.vbank_name);
						        	console.log('가상계좌 입금 예금주 : ' + rsp.vbank_holder);
					        	}
					        	
					        	if(rsp.pay_method=='trans') { //실시간 계좌이체인 경우
					        		//결제 응답 파라미터 참조
					        	}
					        	
					        	if(rsp.pay_method=='phone') { //휴대폰 소액결제인 경우
					        		//결제 응답 파라미터 참조	
					        	}						        	

					        	if(rsp.pay_method=='samsung') { //삼성페이인 경우
					        		//결제 응답 파라미터 참조
					        	}
					        	
					        	if(rsp.pay_method=='kakaopay') { //카카오페이인 경우
					        		//결제 응답 파라미터 참조
					        	}
					        	
					        	if(rsp.pay_method=='naverpay') { //네이버페이인 경우
					        		//결제 응답 파라미터 참조
					        	}
					        	
					        	//여기에 나머지 코딩
					        	
					        	
				        	} else {
				        		//결제가 실패되었을 경우
				        		console.log('에러 코드 : '+rsp.error_code);
				        		console.log('에러 메시지 : '+rsp.error_msg);
				        	}
				        	
				        	console.log('결제 상태 : '+rsp.status);
				        	
				        	
				        	/* 아래 코드는 부분은 원래 if (rsp.success) { ... } 블록의 가장 아래에 넣어야 합니다.
				        		연습이므로 밖에 기술하였음
				        	*/
				        	
				        	pay_num = card_name+" : "+card_number;
				        	
				        	var msg = "";
				        	msg += "결제수단 : "+pay_method+"<br>";
				        	msg += "결제번호 : "+pay_num+"<br>";
				        	msg += "결제금액 : "+money+"<br>";
				        	msg += "거래 승인 번호 : "+gt_id+"<br>";
				        	
				        	$("#status").val("pay");
				        	$("#merchantUid").val(merchantUid);
				        	
				        	$("#paymethod").val(pay_method);	
				        	$("#paynum").val(pay_num);
				        	$("#gtid").val(gt_id);
				        	
                            $("#msg").html(msg);
				            $(".result_item").css("display", "");
                            $("#salesBtn").css("display", "inline-block");
                            
                            
				        });
					});
				        
				});
				</script>
				<script>
				$(document).ready(function(){
				    // #ck2 checkbox가 클릭되었을 때
				    $("#ck2").click(function(){
				        // 체크 상태를 확인하여 작업을 수행
				        if($(this).is(':checked')){
				            // 체크되었을 때 실행할 작업
				       		$("#rname").val($("#name").val());
				       		$("#addr1").val($("#cusaddr").val());
				       		$("#addr2").val($("#cusaddr2").val());
				       		$("#postcode").val($("#cuspostcode").val());
				       		$("#tel").val($("#custel").val());
				       		$("#isAddrBtn").css("display","none");
				        } else {
				            // 체크가 해제되었을 때 실행할 작업
				       		$("#rname").val("");
				       		$("#addr1").val("");
				       		$("#addr2").val("");
				       		$("#postcode").val("");
				       		$("#tel").val("");
				       		$("#isAddrBtn").css("display","inline-block");
				        }
				    });
				});
				</script>
			</div>
   		</div>
    </main>
</div>    
</body>
</html>