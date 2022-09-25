package com.example.libs

import androidx.annotation.StringRes

data class UIError(@StringRes val titleKey: Int, @StringRes val messageKeys: List<Int>)