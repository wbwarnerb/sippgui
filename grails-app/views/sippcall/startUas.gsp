<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>SIPp - UAS</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
	<table>
		<tr>
			<td>

	

		<g:form name="sippForm" controller="sippcall" action="placeCall">
		<p><h3>Phone number:</h3></p>
		<g:select name="phoneNumber" from = "${['12132830920'] }" value="12132830920" noSelection="['':'-Choose the phone number -']"/>
		<p><h3>Calls Per Second:</h3></p>
		<g:select name="cps" from="${1..30}" value="1"
          noSelection="['':'-Choose your CPS -']"/>
		<p><h3>Max Calls:</h3></p>
		<g:select name="maxCount" from="${['1', '10', '50', '100', '500', '1000', '2000']}" value="1"/>
		<p><h3>How Long to Hold Audio Open (ms):</h3></p>
		<g:select name="delay" from="${['1200', '5000', '10000', '20000', '60000', '120000']}" value="1000"
          noSelection="['':'-Choose the delay -']"/>
          <p><h3>Scenario:</h3> </p>
          <g:select name="scenario" from ="${['uac.xml', 'codec_speex.xml', 'codec_g729.xml', 'carrier_sprint.xml'] }"
        	value = "uac.xml" />
		<g:actionSubmit value="Place Call" action="placeCall"/>
		</g:form>
				</td>
				
		<td>
		<h2>Stop UAS</h2>
		<g:form name="uasForm" controller="sippcall" action="stopUas">
        <g:actionSubmit value="Stop UAS" action="stopUas"/>
		</g:form>
		</td>				
		</tr>
			
	</table>	
	</body>
</html>
