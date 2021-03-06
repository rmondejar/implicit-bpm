<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Accounting" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="${resource(dir: 'images', file: 'favicon.ico')}"
	type="image/x-icon">

<g:layoutHead />
<r:require modules="jquery, bootstrap" />
<r:layoutResources />
<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"
	type="text/css">
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
</head>
<body>
	<div class="container">
		<div id="header">
			<div id="logo" role="banner">
				<a href="http://implicit-bpm.sf.net"><img
					src="${resource(dir: 'images', file: 'logo.png')}"
					alt="Implict BPM" /></a>
				<p style="font-size: 2em;font-family: Times New Roman">Accounting</p>
			</div>
			<div id="area-cont">
			
				<div id="area">
					<span>Demo mode activated</span>
				
				</div>
		
			</div>
			
		</div>
		<div class="content-body">			
			<g:layoutBody />
		</div>
		<div class="footer" role="contentinfo">
			<p>PetStore Classic Application</p>
		</div>
	</div>

	<div id="spinner" class="spinner" style="display: none;">
		<g:message code="spinner.alt" default="Loading&hellip;" />
	</div>
	<g:javascript library="application" />
	<r:layoutResources />
</body>
</html>