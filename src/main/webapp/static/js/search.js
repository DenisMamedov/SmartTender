$(function () {
    $("#extended").click(function () {
        $("#more").show();
        $("#but").hide();
    });
    $("#rollup").click(function () {
        $("#more").hide();
        $("#but").show();
    });
    $('.navigatorItem').on('click', function() {
        var id = ('.'+$(this).attr("id"));

        $(id).toggle();
    });

});