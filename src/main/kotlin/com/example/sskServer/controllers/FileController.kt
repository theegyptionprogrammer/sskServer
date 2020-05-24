package com.example.sskServer.controllers

import org.springframework.web.bind.annotation.RestController


@RestController
class FileController {
/*
    @RequestMapping(value = ["upload-photo"], method = [RequestMethod.POST])
    fun handleFileUpload(@RequestParam("idNo") idNo: String, @RequestParam("file") file: MultipartFile, uiModel: Model?): String? { // only do the upload if user selected file to upload
        return if (!file.isEmpty) {
            try { //get worker from db
                val worker: TblWorker = tblWorkerService.findTblWorker(idNo)
                //convert file input stream to byte array, so that we can store it into db.
                val bytes: ByteArray = IOUtils.copy(file.inputStream)
                worker.setPhotoContentLength(java.lang.Long.valueOf(file.size).toInt())
                worker.setPhotoContentType(file.contentType)
                worker.setPhotoBlob(bytes)
                tblWorkerService.updateTblWorker(worker)
                //after done updating the record, redirect back to worker page
                "redirect:/workers/show/" + encodeUrlPathSegment(idNo)
            } catch (e: Exception) {
                "You failed to upload " + idNo + " => " + e.message
            }
        } else {
            "redirect:/workers/show/" + encodeUrlPathSegment(idNo)
        }
    }
*/
}