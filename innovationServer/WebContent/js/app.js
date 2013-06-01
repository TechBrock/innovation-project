	history.forward(1);
	jQuery.noConflict();
	
	//browser NS6
	if (window.sidebar){
	    document.onmousedown= false;
	    document.onclick= true;
	}
	//browser IE4+
	document.onselectstart=new Function ("return false");
	 /****/

	function putFocus(id) {
		document.getElementById(id).focus();
	}
	
	function clearField(id) {
		document.getElementById(id).value = '';
	}