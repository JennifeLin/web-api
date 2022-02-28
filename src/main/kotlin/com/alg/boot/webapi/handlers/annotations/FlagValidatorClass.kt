package com.alg.boot.webapi.handlers.annotations

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext


class FlagValidatorClass : ConstraintValidator<FlagValidator, Int> {
    private lateinit var values: Array<String>
    override fun initialize(flagValidator: FlagValidator) {
        values = flagValidator.value as Array<String>
    }

    override fun isValid(value: Int?, constraintValidatorContext: ConstraintValidatorContext?): Boolean {
        var isValid = false
        if (value == null) {
            return true
        }
        for (i in values.indices) {
            if (values[i] == value.toString()) {
                isValid = true
                break
            }
        }
        return isValid
    }
}
