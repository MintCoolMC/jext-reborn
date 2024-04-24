package me.spartacus04.jext.config

import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import me.spartacus04.jext.config.fields.FieldGuiStyle
import me.spartacus04.jext.config.fields.FieldJukeboxBehaviour
import me.spartacus04.jext.config.fields.FieldLanguageMode
import me.spartacus04.jext.utils.FileBind

data class Config(
    // behaviour settings

    @SerializedName("lang")
    var LANGUAGE_MODE: FieldLanguageMode = FieldLanguageMode.AUTO,

    @SerializedName("jukebox-behaviour")
    var JUKEBOX_BEHAVIOUR : FieldJukeboxBehaviour = FieldJukeboxBehaviour.VANILLA,

    @SerializedName("jukebox-gui-style")
    var GUI_STYLE : FieldGuiStyle = FieldGuiStyle.SCROLL_VERTICAL,

    @SerializedName("jukebox-gui-size")
    var GUI_SIZE : Int = 96,

    @SerializedName("disable-music-overlap")
    var DISABLE_MUSIC_OVERLAP : Boolean = true,

    @SerializedName("disc-loottables-limit")
    var DISC_LIMIT : HashMap<String, Int> = HashMap(),

    @SerializedName("fragment-loottables-limit")
    var FRAGMENT_LIMIT : HashMap<String, Int> = HashMap(),

    @SerializedName("force-resource-pack")
    var FORCE_RESOURCE_PACK : Boolean = false,

    // metrics & updates

    @SerializedName("check-for-updates")
    var CHECK_FOR_UPDATES : Boolean = true,

    @SerializedName("allow-metrics")
    var ALLOW_METRICS : Boolean = true,

    // web-api

    @SerializedName("enable-resource-pack-host")
    var RESOURCE_PACK_HOST : Boolean = true,

    @SerializedName("web-interface-port")
    var WEB_INTERFACE_PORT : Int = 9871,

    @SerializedName("web-interface-api-enabled")
    var WEB_INTERFACE_API_ENABLED : Boolean = true,

    @SerializedName("web-interface-password")
    var WEB_INTERFACE_PASSWORD : String = "",

    @SerializedName("custom-public-ip")
    var CUSTOM_PUBLIC_IP : String = "",

    @SerializedName("enable-resource-pack-download")
    var RESOURCE_PACK_DOWNLOAD : Boolean = true,

    @SerializedName("resource-pack-download-url")
    var RESOURCE_PACK_DOWNLOAD_URL : String = "",
) : FileBind("config.json", object : TypeToken<Config>() {})
