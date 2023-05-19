<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.taptac.bean.MemberBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-TW">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>會員管理</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<style>
#add {
	border: 0.5px solid rgb(195, 195, 195);
	float: right;
	font-size: 14px;
	background-color: #d1f0c2;
}

#del {
	border: 0.5px solid rgb(195, 195, 195);
	font-size: 14px;
	background-color: #ffadadd4;
}

#editStudio {
	border: 0.5px solid rgb(195, 195, 195);
	font-size: 14px;
	background-color: #d1f0c2;
}

#enter {
	border: 0.5px solid rgb(195, 195, 195);
	font-size: 14px;
	background-color: #c2f0ec;
}
</style>
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="/TakeAPhotoTakeAChance/html/index.html">Start Bootstrap</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>
					<li><a class="dropdown-item" href="#!">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="/TakeAPhotoTakeAChance/html/index.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 管理平台
						</a>
						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Layouts
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="layout-static.html">Static
									Navigation</a> <a class="nav-link" href="layout-sidenav-light.html">Light
									Sidenav</a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Pages
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> Authentication
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseAuth"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="login.html">Login</a> <a
											class="nav-link" href="register.html">Register</a> <a
											class="nav-link" href="password.html">Forgot Password</a>
									</nav>
								</div>
								<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
									data-bs-target="#pagesCollapseError" aria-expanded="false"
									aria-controls="pagesCollapseError"> Error
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseError"
									aria-labelledby="headingOne"
									data-bs-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="401.html">401 Page</a> <a
											class="nav-link" href="404.html">404 Page</a> <a
											class="nav-link" href="500.html">500 Page</a>
									</nav>
								</div>
							</nav>
						</div>
						<div class="sb-sidenav-menu-heading">Addons</div>
						<a class="nav-link" href="charts.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Charts
						</a> <a class="nav-link" href="member.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> 會員管理
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">會員管理</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href=/TakeAPhotoTakeAChance/html/index.html>Dashboard</a></li>
						<li class="breadcrumb-item active">會員管理</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							管理會員資料 <br>
							<form method="post" action="html/Member/CreateMember.html">
							<button id="add">新增會員資料</button>
							</form>
						</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> 會員表格
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>會員編號</th>
										<th>會員名稱</th>
										<th>會員帳號</th>
										<th>會員密碼</th>
										<th>會員信箱</th>
										<th>修改資料</th>
										<th>刪除資料</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>會員編號</th>
										<th>會員名稱</th>
										<th>會員帳號</th>
										<th>會員密碼</th>
										<th>會員信箱</th>
										<th>修改資料</th>
										<th>刪除資料</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${members}" var="member">
										<tr>
											
											<td id="memberID">${member.memberID}</td>
											<td>${member.memberName}</td>
											<td>${member.memberAccount}</td>
											<td>${member.memberPassword}</td>
											<td>${member.memberEmail}</td>
											<td>
												<form method="post" action="UpdateMemberServlet1">
													<input type="hidden" name="memberID" id="memberID"
														value="${member.memberID}" /> <input type="submit"
														value="修改" />
												</form>
											</td>
											<td>
												<button id="del" value="" >刪除</button>
											</td>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2023</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<script src="https://kit.fontawesome.com/a260a05f7c.js"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
	        $(function () {
	           
	
	            $('tbody').on('click', '#del', function () {
	            	event.preventDefault();
	            	
	            	let memberID = $(this).closest('tr').find('#memberID').val();
	            	console.log(memberID);
	
	                 Swal.fire({
	                     title: '確認删除？',
	                     text: '您确定要删除這個會員資料吗？',
	                     icon: 'warning',
	                     showCancelButton: true,
	                     confirmButtonColor: '#3085d6',
	                     cancelButtonColor: '#d33',
	                     confirmButtonText: '確認',
	                     cancelButtonText: '取消'
	                 }).then((result) => {
	                     if (result.isConfirmed) {
	                        // $('#deleteform').submit();
	                        
         
	                        let options ={
							          url: 'DeleteMemberServlet',
							          type: 'POST',
							          data: { 
							       
							            memberID: memberID // 将memberID作为参数传递给servlet
							          },
							          success: function(response) {
							            // 成功删除会员数据后的操作
							            Swal.fire({
							            	title :'成功', 
							            	text : '會員數據已删除', 
							            	icon : 'success'
							            }).then((result)=>{
							            	if(result.isConfirmed){
							            		 window.location.href = "GetAllMemberServlet";
							            	}
							            });
							            
							            
							          },
							          error: function(xhr, status, error) {
							            // 处理错误情况
							            console.log(memberID);
							            console.log(xhr);
							            console.log(status);
							            Swal.fire('錯誤', '删除會員數具時發生错误', 'error');
							 
							     }	
		               		   }
							  $.ajax(options);
	               		}               
	        		})
	            })
	        })
    </script>

	

</body>

</html>