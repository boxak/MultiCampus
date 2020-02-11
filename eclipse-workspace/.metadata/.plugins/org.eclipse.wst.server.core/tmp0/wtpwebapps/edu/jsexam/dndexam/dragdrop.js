var source, drop;
function initiate(){
	source=document.getElementById('image');
	source.addEventListener('dragstart', dragged, false);
	//img에 dragstart 이벤트가 발생하면 dragged 함수를 수행해라.
	drop=document.getElementById('dropbox');
	drop.addEventListener('dragover', function(e){console.log("dragover"); e.preventDefault(); }, false);
	drop.addEventListener('drop', dropped, false);
}
function dragged(e){
	console.log("dragstart");
	var code='<img src="'+source.getAttribute('src')+'">';
	e.dataTransfer.setData('Text', code);
}
function dropped(e){
	console.log("drop");
	e.preventDefault();
	drop.innerHTML+=e.dataTransfer.getData('Text');
}
window.addEventListener('load', initiate);







