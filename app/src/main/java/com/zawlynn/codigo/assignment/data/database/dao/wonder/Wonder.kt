package com.zawlynn.codigo.assignment.data.database.dao.wonder

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity
class Wonder() : Parcelable {
    @PrimaryKey
    var location: String=""
    var description: String?=null
    var image: String?=null
    var lat: Double?=null
    @SerializedName("long")
    var lng: Double?=null

    constructor(parcel: Parcel) : this() {
        location = parcel.readString()
        description = parcel.readString()
        image = parcel.readString()
        lat = parcel.readValue(Double::class.java.classLoader) as? Double
        lng = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Wonder)
            return false
        val mdc = other as Wonder?
        return mdc!!.location.equals(location, ignoreCase = true)
    }

    override fun hashCode(): Int {
        var result = location.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (image?.hashCode() ?: 0)
        result = 31 * result + (lat?.hashCode() ?: 0)
        result = 31 * result + (lng?.hashCode() ?: 0)
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(location)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeValue(lat)
        parcel.writeValue(lng)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Wonder> {
        override fun createFromParcel(parcel: Parcel): Wonder {
            return Wonder(parcel)
        }

        override fun newArray(size: Int): Array<Wonder?> {
            return arrayOfNulls(size)
        }
    }

}

