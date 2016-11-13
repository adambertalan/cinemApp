var webSocket;
		
		window.onload = openSocket;
		window.onunload = closeSocket;

		function openSocket() {
			// Ensures only one connection is open at a time
			if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			// Create a new instance of the websocket
			var host = window.location.host;
			webSocket = new WebSocket("ws://" + host + "/CinemApp-web/cinemappWS");


			webSocket.onopen = function(event) {
				if (event.data === undefined)
					return;
			};

			webSocket.onmessage = function(event) {
				console.log("Üznenet jött");
				console.log(event);
				// az üzenet: event.data
				// frissítünk akkor
				document.getElementById("form:upbutton").click();
			};

			webSocket.onclose = function(event) {
				webSocket.close();
			};
		}

		function send() {
			webSocket.send("UP");
		}