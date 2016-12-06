var webSocket;

		// runs openSocket() on page load
		window.onload = openSocket;
		
		var oldTheatreId;
		var oldMovieShowId;
		
		var movieShowId = Number(getURLParameter("movieShowId"));
		var theatreId = Number(getURLParameter("theatreId"));
		
		function getURLParameter(name) {
			  return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
			}
		
		function openSocket() {
//			alert("openSocket");
			console.log("socket.js: openSocket()");
			console.log("movieShowId: " + movieShowId + " theatreId: " + theatreId );
			
			if( movieShowId == 0 || theatreId == 0 ){
				$('.modalPseudoClass').modal();
				return;
			}
			
			oldTheatreId = theatreId;
			oldMovieShowId = movieShowId;
			
			// Ensures only one connection is open at a time
			if (webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			// Create a new instance of the websocket
			var host = window.location.host;
			
			webSocket = new WebSocket("ws://" + host + "/CinemApp-web/cinemappWS/" + movieShowId);
			
			// call managedbean method reload() with movieShowId and theatreId
			// <o:commandScript name="reload" action="#{bookSeatBean.reload}"></o:commandScript>
			reload({movieShowId: movieShowId, theatreId: theatreId});
			
			// websocket onOpen function
			webSocket.onopen = function(event) {
				if (event.data === undefined)
					return;
			};

			// websocket onMessage function
			webSocket.onmessage = function(event) {
				console.log("socket.js: Message received!");
				console.log(event);
				
				var json = JSON.parse(event.data);
				
				// az üzenet: event.data
				// frissítünk akkor
				// call managedbean method update() with seatId, movieShowId and occupyOrFree
				// <o:commandScript name="update" action="#{bookSeatBean.update}" render="@form"></o:commandScript>
				update({ seatId: json.seatId, movieShowId: json.movieShowId, occupyOrFree: json.occupyOrFree} );
			};

			// websocket onClose function
			webSocket.onclose = function(event) {
				webSocket.close();
			};
		}

		// send message to websocket
		function send( theatreId, movieShowId, seatId , occupyOrFree ) {
			// sending message: which theatre I booking on, which movieShow, which seat, and am I occupy it or free it
			console.log("socket.js: sending message: " + theatreId, movieShowId, seatId, occupyOrFree );
			var obj = { 'theatreId': theatreId, 'movieShowId': movieShowId, 'seatId': seatId, 'occupyOrFree': occupyOrFree };
			webSocket.send( JSON.stringify(obj) );
		}