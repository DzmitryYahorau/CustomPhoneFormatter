package com.dmtr.phoneformatter


class PhoneCountry(var country: String, var phoneCode: String, var mask: String) {

    fun getMaskWithCode(): String? {
        return phoneCode.replace("(?s).".toRegex(), MASK_CHARACTER).plus(" ").plus(mask)
    }

    companion object {
        val MASK_CHARACTER = "N"
    }
}
