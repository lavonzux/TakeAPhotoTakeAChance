<%@ page import="com.product.bean.CameraBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Static Navigation - SB Admin</title>
<link href="/TakeAPhotoTakeAChance/css/styles.css" rel="stylesheet" />
<style>
.abc {
	text-align: center;
}
</style>
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="index.html">Start Bootstrap</a>
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
					<li><hr class="dropdown-divider" /></li>
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
						<a class="nav-link" href="index.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Dashboard
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
						</a> <a class="nav-link" href="tables.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Tables
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
					<h1 class="mt-4">鏡頭數據更新</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active"></li>
					</ol>
					<div class="card mb-4">
						<div class="card-body abc">
							<p class="mb-0">
								<jsp:useBean id="lens" scope="request"
									class="com.product.bean.LensBean" />

							<form action="/TakeAPhotoTakeAChance/UpdateLensServlet" method="POST">
								<label for="lensModel">鏡頭型號:</label>
		<input type="text" id="lensModel" name="lensModel"
									value="<%=lens.getLensModel()%>"><br>

		<label for="lensBrand">鏡頭品牌:</label>
		<input type="text" id="lensBrand" name="lensBrand"
									value="<%=lens.getLensBrand()%>"><br>

		<label for="lensPrice">鏡頭價格:</label>
		<input type="text" id="lensPrice" name="lensPrice"
									value="<%=lens.getLensPrice()%>"><br>

		<label for="lensMount">鏡頭接環:</label>
		<input type="text" id="lensMount" name="lensMount"
									value="<%=lens.getLensMount()%>"><br>

		<label for="lensFocalLength">鏡頭焦距:</label>
		<input type="text" id="lensFocalLength" name="lensFocalLength"
									value="<%=lens.getLensFocalLength()%>"><br>

		<label for="lensGroup">鏡頭鏡組:</label>
		<input type="text" id="lensGroup" name="lensGroup"
									value="<%=lens.getLensGroup()%>"><br>

		<label for="lensOIS">光學防手震:</label>
		<input type="text" id="lensOIS" name="lensOIS"
									value="<%=lens.getLensOIS()%>"><br>

		<label for="lensMagnification">放大倍率:</label>
		<input type="text" id="lensMagnification" name="lensMagnification"
									value="<%=lens.getLensMagnification()%>"><br>

		<label for="lensMinFocusDist">最近對焦距離:</label>
		<input type="text" id="lensMinFocusDist" name="lensMinFocusDist"
									value="<%=lens.getLensMinFocusDist()%>"><br>

		<label for="lensApertureMin">最小光圈:</label>
		<input type="text" id="lensApertureMin" name="lensApertureMin"
									value="<%=lens.getLensApertureMin()%>"><br>

		<label for="lensApertureMax">最大光圈:</label>
		<input type="text" id="lensApertureMax" name="lensApertureMax"
									value="<%=lens.getLensApertureMax()%>"><br>

		<label for="lensBlades">光圈葉片:</label>
		<input type="text" id="lensBlades" name="lensBlades"
									value="<%=lens.getLensBlades()%>"><br>

		<label for="lensFilterSize">濾鏡尺寸:</label>
		<input type="text" id="lensFilterSize" name="lensFilterSize"
									value="<%=lens.getLensFilterSize()%>"><br>

		<label for="lensDims">鏡頭尺寸:</label>
		<input type="text" id="lensDims" name="lensDims"
									value="<%=lens.getLensDims()%>"><br>

		<label for="lensWeight">鏡頭重量:</label>
		<input type="text" id="lensWeight" name="lensWeight"
									value="<%=lens.getLensWeight()%>"><br>

		<label for="lensFOV">鏡頭視角:</label>
		<input type="text" id="lensFOV" name="lensFOV"
									value="<%=lens.getLensFOV()%>"><br>

		<label for="lensDrive">驅動方式:</label>
		<input type="text" id="lensDrive" name="lensDrive"
									value="<%=lens.getLensDrive()%>"><br>

		<input type="submit" value="Update">
	</form></p>
							
                            </div>
                        </div>
                        <div style="height: 100vh"></div>
                        <div class="card mb-4">
						<div class="card-body">When scrolling, the navigation stays at the top of the page. This is the end of the static navigation demo.</div>
					</div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div
						class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
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
        <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
        <script src="/MainProject/js/scripts.js"></script>
    </body>
</html>
