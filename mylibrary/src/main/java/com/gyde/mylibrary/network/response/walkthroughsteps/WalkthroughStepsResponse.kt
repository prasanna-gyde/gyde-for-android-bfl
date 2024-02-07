package com.gyde.mylibrary.network.response.walkthroughsteps

import com.gyde.mylibrary.network.response.walkthroughsteps.Step

data class WalkthroughStepsResponse(
    val _id: String,
    val appId: String,
    val appName: String,
    val draftMode: Int,
    val elId: String,
    val flowId: String,
    val flowInitText: String,
    val flowName: String,
    val origUrl: List<String>,
    val steps: List<Step>,
    val token: String,
    val url: List<String>
)