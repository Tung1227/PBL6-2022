$('.file-input').change(function () {
    var i = $(this).prev('label').clone();
    var file = $('.file-input')[0].files[0].name;
    $('#nameFile').val(file);
});