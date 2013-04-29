(function($) {
    var $navibar = $('#navibar');
    var itemId = $navibar.attr('data-active-navibar-item-id');
    var $link = $navibar.find('[href=' + itemId + ']');
    $link.closest('li').addClass('active');
})(jQuery);