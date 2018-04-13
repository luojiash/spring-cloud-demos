function ajax(options) {
    $.extend(options, {
        error: function (xhr) {
            if (xhr.status === 401) {
                alert('请重新登录');
            }
        }
    });
    $.ajax(options);
}