package com.matans.auth.data

import android.util.Patterns
import com.matans.auth.domain.PatternValidator

object EmailPattrenValidator: PatternValidator {
    override fun matches(value: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches()
    }
}