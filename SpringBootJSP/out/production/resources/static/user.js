$(function() {
    $.ajax({
        url: "http://localhost:8080/conferencejsp/user"
    }).done(function(data) {
        $('.name-info').append(data.name);
        $('.age-info').append(data.age);
    });
});