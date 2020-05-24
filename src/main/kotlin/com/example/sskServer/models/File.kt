package com.example.sskServer.models

import io.swagger.annotations.ApiModelProperty
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Data
@NoArgsConstructor
data class File(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        @ApiModelProperty(position = 1)
        val fileId: Long,
        @Column(name = "name")
        @ApiModelProperty(position = 2)
        val fileName: String,
        @Column(name = "photo-blob")
        @ApiModelProperty(position = 3)
        @Lob
        val fileBlob: ByteArray,
        @Column(name = "photoContentLength")
        @ApiModelProperty(position = 4)
        val photoContentLength: Int,
        @Column(name = "photoContentType")
        @ApiModelProperty(position = 5)
        val photoContentType: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as File

        if (fileId != other.fileId) return false
        if (fileName != other.fileName) return false
        if (!fileBlob.contentEquals(other.fileBlob)) return false
        if (photoContentLength != other.photoContentLength) return false
        if (photoContentType != other.photoContentType) return false

        return true
    }

    override fun hashCode(): Int {
        var result = fileId.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + fileBlob.contentHashCode()
        result = 31 * result + photoContentLength
        result = 31 * result + photoContentType.hashCode()
        return result
    }
}