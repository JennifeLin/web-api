package com.alg.boot.webapi.handlers.annotations

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER)
@Constraint(validatedBy = [FlagValidatorClass::class])
annotation class FlagValidator(
    vararg val value: String = [],
    val message: String = "flag is not found",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
