package com.example.android_assessment_university.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "university")
data class University(
    @PrimaryKey val name: String,
    val domains: List<String>?,
    val web_pages: List<String>,
    val alpha_two_code: String,
    @SerializedName("state-province")
    val state_province: String?,
    val country: String
) : Parcelable {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeStringList(domains)
        parcel.writeStringList(web_pages)
        parcel.writeString(alpha_two_code)
        parcel.writeString(state_province)
        parcel.writeString(country)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<University> {
        override fun createFromParcel(parcel: Parcel): University {
            return University(
                name = parcel.readString()!!,
                domains = parcel.createStringArrayList()!!,
                web_pages = parcel.createStringArrayList()!!,
                alpha_two_code = parcel.readString()!!,
                state_province = parcel.readString(),
                country = parcel.readString()!!
            )
        }

        override fun newArray(size: Int): Array<University?> {
            return arrayOfNulls(size)
        }
    }
}