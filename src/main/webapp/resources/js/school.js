messages = {};

$(document).ready(function () {
    // Toggle warning style.
    $("span[data-server-validation-error]").each(function (index, element) {
        var element = $(element);
        var selector = element.attr("data-server-validation-error");
        var target = $(selector);

        target.tooltip({
            "title": element.text(),
            "placement": "top"
        });
        target.addClass("form-error");
    });
    /////////

    $('.confirmation').on('click', function () {
        return confirm(messages["delete.confirm.message"]);
    });
});

