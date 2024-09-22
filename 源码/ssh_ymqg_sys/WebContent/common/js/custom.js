// 为所有有二级菜单的一级菜单添加标签
$( "<b class='sl-icon'></b>" ).insertBefore( ".sub-menu" );

// 边栏随窗口移动
$.fn.extend({
    scrollFollow: function(d) {
        d = d || {};
        d.container = d.container || $(this).parent();
        d.bottomObj = d.bottomObj || '';
        d.bottomMargin = d.bottomMargin || 0;
        d.marginTop = d.marginTop || 0;
        d.marginBottom = d.marginBottom || 0;
        d.zindex = d.zindex || 0;
        var e = $(window);
        var f = $(this);
        if (f.length <= 0) {
            return false
        }
        var g = f.position().top;
        var h = d.container.height();
        var i = f.css("position");
        if (d.bottomObj == '' || $(d.bottomObj).length <= 0) {
            var j = false
        } else {
            var j = true
        }
        e.scroll(function(a) {
            var b = f.height();
            if (f.css("position") == i) {
                g = f.position().top
            }
            scrollTop = e.scrollTop();
            topPosition = Math.max(0, g - scrollTop);
            if (j == true) {
                var c = $(d.bottomObj).position().top - d.marginBottom - d.marginTop;
                topPosition = Math.min(topPosition, (c - scrollTop) - b)
            }
            if (scrollTop > g) {
                if (j == true && (g + b > c)) {
                    f.css({
                        position: i,
                        top: g
                    })
                } else {
                    if (window.XMLHttpRequest) {
                        f.css({
                            position: "fixed",
                            top: topPosition + d.marginTop,
                            'z-index': d.zindex
                        })
                    } else {
                        f.css({
                            position: "absolute",
                            top: scrollTop + topPosition + d.marginTop + 'px',
                            'z-index': d.zindex
                        })
                    }
                }
            } else {
                f.css({
                    position: i,
                    top: g
                })
            }
        });
        return this
    }
});


$(document).ready(function() {
    $(".sidebar .move").scrollFollow({
        bottomObj: '.footer',
        marginTop: 20,
        marginBottom: 32
    })
});

// 响应式菜单
function createMobileMenu(menu_id, mobile_menu_id) {
    // 创建下拉选项
    jQuery("<select />").appendTo(menu_id);
    jQuery(menu_id).find('select').first().attr("id", mobile_menu_id);

    // 填充下拉选项
    jQuery(menu_id).find('a').each(function() {
        var el = jQuery(this);

        var selected = '';
        if (el.parent().hasClass('current-menu-item') == true) {
            selected = "selected='selected'";
        }

        var depth = el.parents("ul").size();
        var space = '';
        if (depth > 1) {
            for (i = 1; i < depth; i++) {
                space += '&nbsp;&nbsp;';
            }
        }

        jQuery("<option " + selected + " value='" + el.attr("href") + "'>" + space + el.text() + "</option>").appendTo(jQuery(menu_id).find('select').first());
    });
    jQuery(menu_id).find('select').first().change(function() {
        window.location = jQuery(this).find("option:selected").val();
    });
}

jQuery(document).ready(function() {
    if (jQuery('.header-menu').length > 0) {
        createMobileMenu('.header-menu', 'responsive-nav');
    };
    if (jQuery('.footer-menu').length > 0) {
        createMobileMenu('.footer-menu', 'responsive-nav');
    }
});



//回顶部
$(window).scroll(function() {
    if ($(window).scrollTop() > 600) {
        $("#back-to-top").fadeIn(200);
    } else {
        $("#back-to-top").fadeOut(200);
    }
});

$('#back-to-top, .back-to-top').click(function() {
    $('html, body').animate({
        scrollTop: 0
    }, '800');
    return false;
});

//微信弹出
jQuery(function(a) {
    a(".qr").hover(function() {
            a(this).find(".weixin_content").slideDown(200)
        },
        function() {
            a(this).find(".weixin_content").hide(0)
        })
});


// 暗窗弹出
$(function(){
    $('.boxer').boxer({
        requestKey: 'abc123',
        labels: {
            close: "关闭",
            count: "/",
            next: "下一个",
            previous: "上一个"
        }
    });
});

// 幻灯片
$(function() {
    $('.slides').slidesjs({
        width: 900,
        height: 420,
        play: {
            active: true,
            auto: true,
            interval: 4000,
            swap: true
        }
    });
});


// 简码中的开关盒
jQuery(document).ready(function(){    
    // Toggle Box
    jQuery("ul.gdl-toggle-box li,ul.archives li").each(function(){
        jQuery(this).children(".toggle-box-content,.archives-monthlisting").not(".active").css('display','none');
        $('.archives ul.archives-monthlisting:first').show();
        
        jQuery(this).children(".toggle-box-head,.archives .m-title").bind("click", function(){
            jQuery(this).children().addClass(function(){
                if(jQuery(this).hasClass("active")){
                    jQuery(this).removeClass("active");
                    return "";
                }
                return "active";
            });
            jQuery(this).siblings(".toggle-box-content,.archives-monthlisting").slideToggle();
        });
    });
});


// TABS
$(function(){
    $('#tabs li:first,#tab_content > div:first').addClass('current');
    $('#tabs li a').click(function(e){
        $('#tabs li, #tab_content .current').removeClass('current').removeClass('fadeInLeft');
        $(this).parent().addClass('current');
        var currentTab = $(this).attr('href');
        $(currentTab).addClass('current fadeInLeft');
        e.preventDefault();
     
    }); 

});

// HTML5播放器
$( function() { $( 'audio' ).audioPlayer(); } );

(function(e,t,n,r){var i="ontouchstart"in t,s=i?"touchstart":"mousedown",o=i?"touchmove":"mousemove",u=i?"touchend":"mouseup",a=i?"touchcancel":"mouseup",f=function(e){var t=Math.floor(e/3600),n=Math.floor(e%3600/60),r=Math.ceil(e%3600%60);return(t==0?"":t>0&&t.toString().length<2?"0"+t+":":t+":")+(n.toString().length<2?"0"+n:n)+":"+(r.toString().length<2?"0"+r:r)},l=function(e){var t=n.createElement("audio");return!!(t.canPlayType&&t.canPlayType("audio/"+e.split(".").pop().toLowerCase()+";").replace(/no/,""))};e.fn.audioPlayer=function(t){var t=e.extend({classPrefix:"audioplayer",strPlay:"Play",strPause:"Pause",strVolume:"Volume"},t),n={},r={playPause:"playpause",playing:"playing",time:"time",timeCurrent:"time-current",timeDuration:"time-duration",bar:"bar",barLoaded:"bar-loaded",barPlayed:"bar-played",volume:"volume",volumeButton:"volume-button",volumeAdjust:"volume-adjust",noVolume:"novolume",mute:"mute",mini:"mini"};for(var u in r)n[u]=t.classPrefix+"-"+r[u];this.each(function(){if(e(this).prop("tagName").toLowerCase()!="audio")return false;var r=e(this),u=r.attr("src"),c=r.get(0).getAttribute("autoplay"),c=c===""||c==="autoplay"?true:false,h=r.get(0).getAttribute("loop"),h=h===""||h==="loop"?true:false,p=false;if(typeof u==="undefined"){r.find("source").each(function(){u=e(this).attr("src");if(typeof u!=="undefined"&&l(u)){p=true;return false}})}else if(l(u))p=true;var d=e('<div class="'+t.classPrefix+'">'+(p?e("<div>").append(r.eq(0).clone()).html():'<embed src="'+u+'" width="0" height="0" volume="100" autostart="'+c.toString()+'" loop="'+h.toString()+'" />')+'<div class="'+n.playPause+'" title="'+t.strPlay+'"><a href="#">'+t.strPlay+"</a></div></div>"),v=p?d.find("audio"):d.find("embed"),v=v.get(0);if(p){d.find("audio").css({width:0,height:0,visibility:"hidden"});d.append('<div class="'+n.time+" "+n.timeCurrent+'"></div><div class="'+n.bar+'"><div class="'+n.barLoaded+'"></div><div class="'+n.barPlayed+'"></div></div><div class="'+n.time+" "+n.timeDuration+'"></div><div class="'+n.volume+'"><div class="'+n.volumeButton+'" title="'+t.strVolume+'"><a href="#">'+t.strVolume+'</a></div><div class="'+n.volumeAdjust+'"><div><div></div></div></div></div>');var m=d.find("."+n.bar),g=d.find("."+n.barPlayed),y=d.find("."+n.barLoaded),b=d.find("."+n.timeCurrent),w=d.find("."+n.timeDuration),E=d.find("."+n.volumeButton),S=d.find("."+n.volumeAdjust+" > div"),x=0,T=function(e){theRealEvent=i?e.originalEvent.touches[0]:e;v.currentTime=Math.round(v.duration*(theRealEvent.pageX-m.offset().left)/m.width())},N=function(e){theRealEvent=i?e.originalEvent.touches[0]:e;v.volume=Math.abs((theRealEvent.pageY-(S.offset().top+S.height()))/S.height())},C=setInterval(function(){y.width(v.buffered.end(0)/v.duration*100+"%");if(v.buffered.end(0)>=v.duration)clearInterval(C)},100);var k=v.volume,L=v.volume=.111;if(Math.round(v.volume*1e3)/1e3==L)v.volume=k;else d.addClass(n.noVolume);w.html("…");b.text(f(0));v.addEventListener("loadeddata",function(){w.text(f(v.duration));S.find("div").height(v.volume*100+"%");x=v.volume});v.addEventListener("timeupdate",function(){b.text(f(v.currentTime));g.width(v.currentTime/v.duration*100+"%")});v.addEventListener("volumechange",function(){S.find("div").height(v.volume*100+"%");if(v.volume>0&&d.hasClass(n.mute))d.removeClass(n.mute);if(v.volume<=0&&!d.hasClass(n.mute))d.addClass(n.mute)});v.addEventListener("ended",function(){d.removeClass(n.playing)});m.on(s,function(e){T(e);m.on(o,function(e){T(e)})}).on(a,function(){m.unbind(o)});E.on("click",function(){if(d.hasClass(n.mute)){d.removeClass(n.mute);v.volume=x}else{d.addClass(n.mute);x=v.volume;v.volume=0}return false});S.on(s,function(e){N(e);S.on(o,function(e){N(e)})}).on(a,function(){S.unbind(o)})}else d.addClass(n.mini);if(c)d.addClass(n.playing);d.find("."+n.playPause).on("click",function(){if(d.hasClass(n.playing)){e(this).attr("title",t.strPlay).find("a").html(t.strPlay);d.removeClass(n.playing);p?v.pause():v.Stop()}else{e(this).attr("title",t.strPause).find("a").html(t.strPause);d.addClass(n.playing);p?v.play():v.Play()}return false});r.replaceWith(d)});return this}})(jQuery,window,document)


// 在新窗口打开评论者链接
function externallinks() {
    if (!document.getElementsByTagName) return;
    var anchors = document.getElementsByTagName("a");
    for (var i = 0; i < anchors.length; i++) {
        var anchor = anchors[i];
        if (anchor.getAttribute("href") && anchor.getAttribute("rel") == "external nofollow") {
            anchor.target = "_blank";
        }
    }
}
window.onload = externallinks;