var webSocket;

		window.onload = openSocket;
		
		var oldTheatreId;
		var oldMovieShowId;

		function getURLParameter(name) {
			  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
			}
		
		var movieShowId = Number(getURLParameter("movieShowId"));
		var theatreId = Number(getURLParameter("theatreId"));
		
		function openSocket() {
			oldTheatreId = theatreId;
			oldMovieShowId = movieShowId;
			
			
			
			
			// Ensures only one connection is open at a time
			if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			// Create a new instance of the websocket
			var host = window.location.host;
			
			console.log("moviShowId at openSocket: " + movieShowId);
			webSocket = new WebSocket("ws://" + host + "/CinemApp-web/cinemappWS/" + movieShowId);
			
//			if( oldTheatreId != theatreId || oldMovieShowId != movieShowId ){
				reload({movieShowId: movieShowId, theatreId: theatreId});	
//			}
			
//			document.getElementById("form:upbutton").click();
			
			webSocket.onopen = function(event) {
				if (event.data === undefined)
					return;
			};

			webSocket.onmessage = function(event) {
				console.log("Üznenet jött");
				console.log(event);
				var json = JSON.parse(event.data);
				
				// az üzenet: event.data
				// frissítünk akkor
//				document.getElementById("form:upbutton").click();
				update({ seatId: json.seatId, movieShowId: json.movieShowId, occupyOrFree: json.occupyOrFree} );
			};

			webSocket.onclose = function(event) {
				webSocket.close();
			};
		}

		function send( theatreId, movieShowId, seatId , occupyOrFree ) {
			console.log("JS: sending: " + theatreId, movieShowId, seatId, occupyOrFree );
			var obj = { 'theatreId': theatreId, 'movieShowId': movieShowId, 'seatId': seatId, 'occupyOrFree': occupyOrFree };
			webSocket.send( JSON.stringify(obj) );
		}