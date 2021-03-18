package org.abimon.eternalJukebox.objects

data class SpotifyTrack(
        val href: String,
        val id: String,
        val name: String,
        val uri: String,
        val duration_ms: Long,
        val explicit: Boolean,
        val artists: Array<SpotifyArtist>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SpotifyTrack

        if (href != other.href) return false
        if (id != other.id) return false
        if (name != other.name) return false
        if (uri != other.uri) return false
        if (duration_ms != other.duration_ms) return false
        if (explicit != other.explicit) return false
        if (!artists.contentEquals(other.artists)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = href.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + uri.hashCode()
        result = 31 * result + duration_ms.hashCode()
        result = 31 * result + explicit.hashCode()
        result = 31 * result + artists.contentHashCode()
        return result
    }
}

data class SpotifyArtist(
        val id: String,
        val name: String
)

data class SpotifyAudio(
        val meta: SpotifyAudioMeta,
        val track: SpotifyAudioTrack,
        val bars: Array<SpotifyAudioBar>,
        val beats: Array<SpotifyAudioBeat>,
        val tatums: Array<SpotifyAudioTatum>,
        val sections: Array<SpotifyAudioSection>,
        val segments: Array<SpotifyAudioSegment>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SpotifyAudio

        if (meta != other.meta) return false
        if (track != other.track) return false
        if (!bars.contentEquals(other.bars)) return false
        if (!beats.contentEquals(other.beats)) return false
        if (!tatums.contentEquals(other.tatums)) return false
        if (!sections.contentEquals(other.sections)) return false
        if (!segments.contentEquals(other.segments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = meta.hashCode()
        result = 31 * result + track.hashCode()
        result = 31 * result + bars.contentHashCode()
        result = 31 * result + beats.contentHashCode()
        result = 31 * result + tatums.contentHashCode()
        result = 31 * result + sections.contentHashCode()
        result = 31 * result + segments.contentHashCode()
        return result
    }
}

data class SpotifyAudioMeta(
        val analyzer_version: String,
        val platform: String,
        val detailed_status: String,
        val status_code: Int,
        val analysis_time: Double,
        val input_process: String
)

data class SpotifyAudioTrack(
        val duration: Double,
        val loudness: Double,
        val tempo: Int,
        val time_signature: Int,
        val key: Int,
        val mode: Int
)

data class SpotifyAudioBar(
        val start: Double,
        val duration: Double,
        val confidence: Double
)

data class SpotifyAudioBeat(
        val start: Double,
        val duration: Double,
        val confidence: Double
)

data class SpotifyAudioTatum(
        val start: Double,
        val duration: Double,
        val confidence: Double
)

data class SpotifyAudioSection(
        val start: Double,
        val duration: Double,
        val confidence: Double,
        val loudness: Double,
        val tempo: Double,
        val tempo_confidence: Double,
        val key: Int,
        val key_confidence: Double,
        val mode: Int,
        val mode_confidence: Double,
        val time_signature: Int,
        val time_signature_confidence: Double
)

data class SpotifyAudioSegment(
        val start: Double,
        var duration: Double,
        val confidence: Double,
        val loudness_start: Int,
        val loudness_max_time: Int,
        val loudness_max: Int,
        val pitches: DoubleArray,
        val timbre: DoubleArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SpotifyAudioSegment

        if (start != other.start) return false
        if (duration != other.duration) return false
        if (confidence != other.confidence) return false
        if (loudness_start != other.loudness_start) return false
        if (loudness_max_time != other.loudness_max_time) return false
        if (loudness_max != other.loudness_max) return false
        if (!pitches.contentEquals(other.pitches)) return false
        if (!timbre.contentEquals(other.timbre)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = start.hashCode()
        result = 31 * result + duration.hashCode()
        result = 31 * result + confidence.hashCode()
        result = 31 * result + loudness_start
        result = 31 * result + loudness_max_time
        result = 31 * result + loudness_max
        result = 31 * result + pitches.contentHashCode()
        result = 31 * result + timbre.contentHashCode()
        return result
    }
}