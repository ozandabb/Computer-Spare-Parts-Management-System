/*
 *****************************************************
 *	CUSTOM JS DOCUMENT                              *
 *	Single window load event                        *
 *   "use strict" mode on                            *
 *****************************************************
 */
$(window).on("load", function() {

    "use strict";

    var preLoader = $('.preloader');
    var countNumber = $(".count-number");
    var helpButton = $("#help_button");
    var Help = $("#help");
    var dataToggleTooTip = $('[data-toggle="tooltip"]');
    var scrollTop = $('#scroll-top');
    var fancyboxImg = $('.fancybox');
    var headerSticky = $(".sticky-nav");
    var boDy = $('body');
    var scrolls = $('.navbar-nav a[href*="#"]');
    var bodyScroll = $('html, body');
	var mapDiv = $('#gmap_canvas');


    // ============================================
    // Sticky Header
    // =============================================
    if (headerSticky.length) {
        $(window).on('scroll', function() {

            if ($(this).scrollTop() > 30) {
                headerSticky.addClass('sticky-header');
            } else {
                headerSticky.removeClass('sticky-header');
            }
        });
    }
    // ============================================
    // PreLoader On window Load
    // =============================================
    if (preLoader.length) {
        preLoader.fadeOut();
    }
    //========================================
    // Counter
    //======================================== 	
	if(countNumber.length){
		countNumber.appear(function() {
			$(this).each(function() {
				var datacount = $(this).attr('data-count');
				$(this).find('.counter').delay(6000).countTo({
					from: 10,
					to: datacount,
					speed: 8000,
					refreshInterval: 50,
				});
			});
		});
	}

    //============================
    // Search Popup
    //============================
	if(helpButton.length){
		helpButton.on('click', function() {
			Help.slideToggle(1000, function() {
				if (helpButton.val() == "close") {
					helpButton.val("show table");
				} else {
					helpButton.val("close");
				}
			});
		});
	}

    //========================================
    // Owl Carousel functions Calling
    //======================================== 	
    owlCarouselInit();
    //========================================
    // Scroll top
    //======================================== 		
    if (scrollTop.length) {
        scrollTop.on('click', function() {
            boDy.animate({
                    scrollTop: 0
                },
                2000);
        });

        $(window).on('scroll', function() {

            if ($(this).scrollTop() > 500) {
                scrollTop.addClass('showScrollTop');
            } else {
                scrollTop.removeClass('showScrollTop');
            }
        });
    }
	if(scrolls.length){
		scrolls.on('click', function(e) {
			e.preventDefault();
			bodyScroll.animate({
				scrollTop: $($(this).attr('href')).offset().top
			}, 1000, 'linear');
		});
	}
    //===================
    // FANCY-BOX SECTION
    //===================

    if (fancyboxImg.length) {
        fancyboxImg.fancybox();
    }
	//===================
    // MAP SECTION
    //===================
	if (mapDiv.length) {
        initMap();
    }

});
//========================================
// Owl Carousel functions
//======================================== 	

function owlCarouselInit() {

    "use strict";

    //========================================
    // owl carousels settings
    //======================================== 	
    var aboutSlider = $('.about-slider');
    var teamSlider = $('.team_slider');
    var testimonialSlider = $('.testimonial-slider');
    var nextNav = '<i class="fa fa-angle-right" aria-hidden="true"></i>';
    var prevNav = '<i class="fa fa-angle-left" aria-hidden="true"></i>';

    if (aboutSlider.length) {
        aboutSlider.owlCarousel({
            loop: true,
            margin: 0,
            nav: true,
            navText: [prevNav, nextNav],
            dots: false,
            autoplay: false,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 1
                },
                1000: {
                    items: 1
                }
            }
        });
    }
    if (testimonialSlider.length) {
        testimonialSlider.owlCarousel({
            loop: true,
            margin: 0,
            nav: false,
            navText: [prevNav, nextNav],
            dots: true,
            autoplay: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 1
                },
                1000: {
                    items: 1
                }
            }
        });
    }
    if (teamSlider.length) {
        teamSlider.owlCarousel({
            loop: true,
            margin: 0,
            nav: true,
            navText: [prevNav, nextNav],
            dots: false,
            autoplay: true,
            responsive: {
                0: {
                    items: 1
                },
                600: {
                    items: 3
                },
                1000: {
                    items: 4
                }
            }
        });
    }
}

function initMap() {
    "use strict";

    var mapDiv = $('#gmap_canvas');

    if (mapDiv.length) {
        var myOptions = {
            zoom: 5,
            scrollwheel: false,
            draggable: true,
            //backgroundColor:grey,
            center: new google.maps.LatLng(22.9623, 76.0508),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
        var marker = new google.maps.Marker({
            map: map,
            position: new google.maps.LatLng(22.9623, 76.0508)
        });
        var infowindow = new google.maps.InfoWindow({
            content: '<strong>ITGEEkS</strong>'
        });
        google.maps.event.addListener(marker, 'click', function() {
            infowindow.open(map, marker);
        });

        infowindow.open(map, marker);

    }
}

var locationMap = $('.itg_map_location');

if (locationMap.length) {
    $(function() {
        var test_plots = {
            "paris": {
                latitude: 48.86,
                longitude: 2.3444444444444,
                tooltip: {
                    content: "Paris"
                }
            },
            "tokyo": {
                latitude: 35.689488,
                longitude: 139.691706,
                tooltip: {
                    content: "Tokyo"
                }
            },
            "moscow": {
                latitude: 55.755786,
                longitude: 37.617633,
                tooltip: {
                    content: "Moscow"
                }
            },
            "los_angeles": {
                latitude: 34.052234,
                longitude: -118.243685,
                tooltip: {
                    content: "Los Angeles"
                }
            },
            "punta_arenas": {
                latitude: -53.163833,
                longitude: -70.917068,
                tooltip: {
                    content: "Punta Arenas"
                }
            },
            "aukland": {
                latitude: -36.84846,
                longitude: 174.763332,
                tooltip: {
                    content: "Aukland"
                }
            },
            "kiruna": {
                latitude: 67.855737,
                longitude: 20.225231,
                tooltip: {
                    content: "Kiruna"
                }
            },
            "reykjavik": {
                latitude: 64.135338,
                longitude: -21.89521,
                tooltip: {
                    content: "Reykjavík"
                }
            },
            "alert": {
                latitude: 82.516305,
                longitude: -62.308482,
                tooltip: {
                    content: "Alert"
                }
            },
            "wales": {
                latitude: 65.609167,
                longitude: -168.0875,
                tooltip: {
                    content: "Wales"
                }
            },
            "tiksi": {
                latitude: 71.625094,
                longitude: 128.872883,
                tooltip: {
                    content: "Tiksi"
                }
            },
            "pretoria": {
                latitude: -25.746019,
                longitude: 28.18712,
                tooltip: {
                    content: "Pretoria"
                }
            },
            "india": {
                latitude: 20.5937,
                longitude: 78.9629,
                tooltip: {
                    content: "India"
                }
            }
        };

        var getElemID = function(elem) {
            // Show element ID
            return $(elem.node).attr("data-id");
        };

        var mapcontainerEqui = $(".mapcontainer_equi");
        var mapcontainerMerc = $(".mapcontainer_merc");
        var mapcontainerMiller = $(".mapcontainer_miller");

        mapcontainerEqui.mapael({
            map: {
                name: "world_countries",
                defaultArea: {
                    tooltip: {
                        content: getElemID
                    }
                }
            },
            plots: test_plots
        });

        mapcontainerMerc.mapael({
            map: {
                name: "world_countries_mercator",
                defaultArea: {
                    tooltip: {
                        content: getElemID
                    }
                }
            },
            plots: test_plots
        });

        mapcontainerMiller.mapael({
            map: {
                name: "world_countries_miller",
                defaultArea: {
                    tooltip: {
                        content: getElemID
                    }
                },
                defaultPlot: {
                    size: 9
                }
            },
            plots: test_plots
        });
    });
}

/*
 *****************************************************
 *	END OF THE JS 									*
 *	DOCUMENT                       					*
 *****************************************************
 */