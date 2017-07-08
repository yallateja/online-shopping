$(function(){
	
	switch(menu){
	case 'About us':
		$("#about").addClass('active');
		break;
	case 'Contact us':
		$("#contact").addClass('active');
		break;
	case 'All Products':
		$("#listproduct").addClass('active');
		break;
	default:
		$("#listproduct").addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	
	}
	
});