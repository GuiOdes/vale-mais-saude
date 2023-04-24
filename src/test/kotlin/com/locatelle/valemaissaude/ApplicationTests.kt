package com.locatelle.valemaissaude

import com.locatelle.valemaissaude.common.BaseTestContainerConfiguration
import com.locatelle.valemaissaude.common.TestContainerCommon
import com.locatelle.valemaissaude.infra.persistence.entity.VideoEntity
import com.locatelle.valemaissaude.infra.persistence.repository.VideoDataRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@TestContainerCommon
class ApplicationTests(
    @Autowired private val videoDataRepository: VideoDataRepository
) : BaseTestContainerConfiguration() {

    @Test
    fun contextLoads() {
        val video = videoDataRepository.save(VideoEntity(null, "aoksmdaoskm"))

        Assertions.assertEquals(videoDataRepository.findById(video.id!!).get().reference, video.reference)
    }
}
