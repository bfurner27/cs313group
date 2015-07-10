/**
 * This will validate that the entire form is prepared to be sent to the 
 * servlet
 * @returns {Boolean}
 */
function validateAddList() {
    var isValid = true;
    
    //validate the name input
    isValid = validateName();
    
    
    return isValid;
}

/**
 * This will validate that the name has text in it, if it does not it will 
 * display an error prompting the user to correct their mistake
 * @returns {Boolean}
 */
function validateName() {
    var nameIsValid = true;
    var name = $('#listNameId').val();
    
    if (name === "") {
        nameIsValid = false;
        $('#listNameId').css("border-color", "red");
        $('#listNameId').attr("placeholder", "(required) ex: The Most Awesome List Ever!");
    }
    else 
    {
        $('#listNameId').css("border-color", "LightGray");
    }
    
    return nameIsValid;
}


