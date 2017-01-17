$(function () {
    $(".required").hover(onIn, onOut);
});

// Функция которая отработает при наведении курсора на элемент

function onOut() {

    $(".req").attr("required");
}

// Функция которая отработает при выходе курсора за элемент

function onIn() {

    $(".req").removeAttr("required");
}