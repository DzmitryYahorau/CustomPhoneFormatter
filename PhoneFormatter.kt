package com.dmtr.phoneformatter


class PhoneFormatter private constructor(private val phoneCountries: List<PhoneCountry>) {

    companion object {
        fun initialize(phoneCountries: List<PhoneCountry>): PhoneFormatter {
            return PhoneFormatter(phoneCountries)
        }
    }

    fun format(text: String): String? {
        if (text.isEmpty()) return ""

        (text.length downTo 1)
                .asSequence()
                .map { text.substring(0, it) }
                .forEach { sub ->
                    //find phone country
                    phoneCountries
                            .firstOrNull { it.phoneCode == (sub) }
                            ?.let {
                                val builder = StringBuilder(text.length)

                                //find numbers and put them in builder
                                (0 until text.length)
                                        .map { text.substring(it, it + 1) }
                                        .filter { "0123456789".contains(it) }
                                        .forEach { builder.append(it) }

                                //find and insert mask symbols into builder
                                it.getMaskWithCode()
                                        ?.let {
                                            var i = 0
                                            while (i < builder.length) {
                                                if (i < it.length) {
                                                    //inside of the mask
                                                    if (it[i] in arrayOf(' ', '(', ')', '-')) {
                                                        builder.insert(i, it[i])
                                                        i++
                                                        continue
                                                    }
                                                } else {
                                                    // out of the mask
                                                    break
                                                }
                                                i++
                                            }
                                        }

                                return builder.toString()
                            }
                }
        return text
    }
}
