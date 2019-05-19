function Header () {
            var $head = $('div.head'),
                $topHeader = $('#top-header'),
                $header = $('#header'),
                $sheader = $('#sheader');

            _header();

            function _header () {
                if ($('div[headerNum]').length) {
                    $header.find('li:eq('+ $('div[headerNum]').attr('headerNum') +')').find('a').addClass('active');
                }
                
              
                $header.on('mouseleave', function (e) {
                    $('#layer').addClass('hide');
                });
                $header.on('mouseenter', '.ful>li', function () {
                    var id = $(this).find('a').attr('id');
                    if (!$head.hasClass('head-bgcolor')) {
                        $('#head').addClass('head-bgcolor shadow delay');
                    }
                    if (id === 'wytz' || id === 'hgyy' ) {
                        $sheader.css('height', id === 'appxz' ? '180px' : '96px');
                        $('#sheader ul[s_h!="'+ id +'"]').addClass('hide');
                        $('ul[s_h="'+ id +'"]').removeClass('hide');
                        $sheader.stop().slideDown(100, function () {
                            $sheader.css('height', id === 'appxz' ? '180px' : '96px');
                        });
                        if (!($('#layer') && $('#layer').length)) {
                            $('body').append('<div id="layer" class="layer-1"></div>');
                        } else {
                            $('#layer').removeClass('hide');
                        }
                    } else {
                        $('#layer').addClass('hide');
                    }
                }).on('mouseleave', '.ful>li', function (e) {
                    var id = $(this).find('a').attr('id');
                    if (id === 'wytz' || id === 'hgyy') {
                        $sheader.slideUp(100, function () {
                            $sheader.css('height', 0);
                        });
                    } else {
                        $('#layer').addClass('hide');
                    }
                });
                $sheader.on('mouseenter', function () {
                    var id = $(this).find('ul:visible').attr('s_h');
                    $sheader.css('height', id === 'appxz' ? '180px' : '96px');
                    $sheader.stop().slideDown(100, function () {
                        if (!($('#layer') && $('#layer').length)) {
                            $('body').append('<div id="layer" class="layer-1"></div>');
                        } else {
                         $('#layer').removeClass('hide');
                        }
                    });
                }).on('mouseleave', function () {
                    var id = $(this).find('ul:visible').attr('s_h');
                    if (id === 'wytz' || id === 'hgyy' ) {
                        $sheader.stop().slideUp(100, function () {
                            $(this).css('height', '0px');
                            $('ul[s_h="'+ id +'"]').addClass('hide');
                            $('#layer').addClass('hide');
                        });
                    }
                });
            }
        }
Header();
