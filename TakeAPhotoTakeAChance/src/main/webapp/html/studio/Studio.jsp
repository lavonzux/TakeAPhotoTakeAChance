<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,com.studio.bean.StudioBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zh-TW">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>場地管理</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="html/studio/css/styles.css" rel="stylesheet" />
		<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
			crossorigin="anonymous"></script>
        <style>
            #add{
                border: 0.5px solid rgb(195, 195, 195);
                float:right;
                font-size: 14px;
                background-color: #d1f0c2;
            }
            #del{
                border: 0.5px solid rgb(195, 195, 195);
                font-size: 14px;
                background-color: #ffadadd4;
            }
            #editStudio{
                border: 0.5px solid rgb(195, 195, 195);
                font-size: 14px;
                background-color: #d1f0c2;
            }
            #enter{
                border: 0.5px solid rgb(195, 195, 195);
                font-size: 14px;
                background-color: #c2f0ec;
            }
            a{
            	color:black;
            	text-decoration:none
            }
        </style>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="/TakeAPhotoTakeAChance/html/index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                管理平台
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="login.html">Login</a>
                                            <a class="nav-link" href="register.html">Register</a>
                                            <a class="nav-link" href="password.html">Forgot Password</a>
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            <a class="nav-link" href="studio.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                場地管理
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
                        <h1 class="mt-4">攝影場地管理</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                管理攝影棚工作室資料
                                <br>
                                <button id="add"><a href="./html/studio/InsertStudio.jsp">新增工作室</a></button>
                            </div>
                            </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                攝影場地管理
                            </div>
                            <div class="card-body">
                            <form method="post" action="${pageContext.request.contextPath}/GetAllStudio">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>工作室編號</th>
                                            <th>攝影棚工作室名稱</th>
                                            <th>管理人</th>
                                            <th>編輯工作室</th>
                                            <th>進入攝影棚編輯</th>
                                            <th>刪除</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>工作室編號</th>
                                            <th>攝影棚工作室名稱</th>
                                            <th>管理人</th>
                                            <th>編輯工作室</th>
                                            <th>進入攝影棚編輯</th>
                                            <th>刪除</th>
                                        </tr>
                                    </tfoot>
								  <tbody>
								    <c:forEach var="studio" items="${studios}">
								      <tr>
								        <td>${studio.studioID}</td>
								        <td>${studio.studioName}</td>
								        <td>${studio.memberID}</td>
								       <td><button id="editStudio"><a href="${pageContext.request.contextPath}/GetStudio?studioID=${studio.studioID}">編輯</a></button></td>
										<td><button id="enter"><a href="${pageContext.request.contextPath}/GetAllShed?studioID=${studio.studioID}">進入</a></button></td>
										<td><button id="del" class="delete-btn" data-studio-id="${studio.studioID}">刪除</button></td>
								      </tr>
								    </c:forEach>
								  </tbody>
				
                                </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; TakeAPhotoTakeAChance</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
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
	<script src="html/studio/js/scripts.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="html/studio/js/datatables-simple-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
        /*

              window.onload = function() {
			    var xhttp = new XMLHttpRequest();
			    xhttp.onreadystatechange = function() {
			      if (this.readyState == 4 && this.status == 200) {
			      }
			    };
			    xhttp.open("GET", "GetAllStudio", true);
			    xhttp.send();
			  };*/

			  $(document).ready(function() {
				  $('.delete-btn').on('click', function() {
				    var studioID = $(this).data('studio-id');
				    if (confirm('確定要刪除此攝影棚工作室？')) {
				      window.location.href = './DeleteStudio?studioID=' + studioID;
				    }
				  });
				});
			  
			  // 取得刪除按鈕
			  const deleteButtons = document.querySelectorAll('#delete-btn');

			  // 取得編輯按鈕
			  const editButtons = document.querySelectorAll('#editStudio');

			  // 綁定刪除按鈕的點擊事件
			  deleteButtons.forEach(deleteButton => {
			    deleteButton.addEventListener('click', () => {
			      const studioId = deleteButton.getAttribute('data-studio-id');
			      const xhr = new XMLHttpRequest();

			      xhr.addEventListener('load', () => {
			        // 刪除成功後重新載入資料
			        reloadStudioTable();
			      });
			      xhr.open("GET", `DeleteStudio`, true);
			      //xhr.open('DELETE', `/DeleteStudio/${studioId}`);
			      xhr.send();
			    });
			  });
			  

        </script>
    </body>
</html>