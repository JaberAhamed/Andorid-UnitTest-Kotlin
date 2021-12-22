package com.example.appunittestpractice.simpleUserRegistration

object Registration {

    /**
     * the input is not valid
     * ...the username/password is empty
     * ...the username length is below 3 character
     * ...the username is already taken
     * ...the confirmed password is not same the real password
     * ...the password contain below 2 digit
     */

    private val existingUser = listOf("Piter", "Carl")
    fun validRegistrationInput(
        username:String,
        password:String,
        confirmePassword:String
    ):Boolean{
        if(username.isEmpty()||password.isEmpty()){
            return false
        }

        if (username.count()<3){
            return false
        }

        if(username in existingUser){
            return false
        }
        if(password.count{it.isDigit()} < 2 || confirmePassword.count{it.isDigit()}<2 ){

            return false
        }

        if(password != confirmePassword){
            return false
        }

        return true
    }
}