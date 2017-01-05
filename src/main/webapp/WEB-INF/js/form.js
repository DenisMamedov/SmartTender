$(function () {
    $("#button_send").mouseover(function() {

        $(".navigatorInput").each(function() {
            var id = ('.'+$(this).attr("id"));
            var val = $(this).val();

            if(val==''){
               $(id).removeAttr("required");

            }
            else{
                $(id).attr("required", true);
            }

});
});
});