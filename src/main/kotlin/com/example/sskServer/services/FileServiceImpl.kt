package com.example.sskServer.services

import org.springframework.stereotype.Service


@Service
class FileServiceImpl : FileService {
/*
    @Autowired
    lateinit var fileRepository: FileRepository

    @Transactional
    override fun uploadFile(file: MultipartFile) {
        val fileName: String = StringUtils.cleanPath(file.originalFilename!!)

        return try { // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw FileStorageException("Sorry! Filename contains invalid path sequence $fileName")
            }
            val dbFile = File(fileName, file.contentType, file.bytes)
            fileRepository.save(file)
        } catch (ex: IOException) {
            throw FileStorageException("Could not store file $fileName. Please try again!", ex)
        }
    }

    @Transactional
    override fun getFile(fileId: String) {
    }

 */
}