/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	menubar Function

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(document).ready(function() {
	if($("#nav").size() != 0){
		gnb_menu();		
	}
});


function gnb_menu(){
	var Tmenu = $("#header #nav>ul");
	Tmenu.intervals = "";
	Tmenu.li = Tmenu.find(">li");
	Tmenu.li.a = Tmenu.li.find(">a");
	Tmenu.li.ul = Tmenu.li.find(">ul");//2댑스
	Tmenu.li.ul.li = Tmenu.li.ul.find(">li");
    Tmenu.li.ul.li.a = Tmenu.li.ul.li.find(">a");
    Tmenu.li.ul.li.ul = Tmenu.li.ul.li.find("ul"); //3댑스
    Tmenu.li.ul.li.ul.li = Tmenu.li.ul.li.ul.find("li"); 
    Tmenu.li.ul.li.ul.li.a = Tmenu.li.ul.li.ul.li.find("a"); 

	$(window).load(function(){
		Tmenu_def(Tmenu);//초기화
	});

	Tmenu.li.a.on("mouseover",function(){
		var idx = Tmenu.li.index($(this).parent());
		Tmenu_open(Tmenu,idx);
    });
    
    Tmenu.li.ul.li.a.on("mouseover",function(){
		var idx = Tmenu.li.ul.li.index($(this).parent());
		Tmenu_sub_open(Tmenu,idx);
	});

	Tmenu.on("mouseleave",function(){
		Tmenu_def(Tmenu);
	});


}

function Tmenu_open(Tmenu,idx){
	var obj = Tmenu.li.eq(idx);
	Tmenu.li.ul.not(":hidden").hide();
	obj.find(">ul").show();
}

function Tmenu_sub_open(Tmenu,idx){
	var obj = Tmenu.li.ul.li.eq(idx);
	Tmenu.li.ul.li.ul.not(":hidden").hide();
	obj.find(">ul").show();
}


function Tmenu_def(Tmenu){
    Tmenu.li.ul.hide();
    if(Tmenu.li.ul.li.ul.size()!==0){
        Tmenu.li.ul.li.ul.hide();
    }

}

