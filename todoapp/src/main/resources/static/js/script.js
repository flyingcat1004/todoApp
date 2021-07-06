$(".clearForm").bind("click", function(){
    $(this.form).find("textarea, :text, select").val("");
});