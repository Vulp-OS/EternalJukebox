package org.abimon.eternalJukebox.objects

data class JukeboxTrack(
        val info: JukeboxInfo,
        val analysis: JukeboxAnalysis,
        val audio_summary: JukeboxSummary
)

data class JukeboxInfo(
        val service: String,
        val id: String,
        val name: String,
        val title: String,
        val artist: String,
        val url: String,
        val duration: Int
)

data class JukeboxAnalysis(
        val sections: Array<SpotifyAudioSection>,
        val bars: Array<SpotifyAudioBar>,
        val beats: Array<SpotifyAudioBeat>,
        val tatums: Array<SpotifyAudioTatum>,
        val segments: Array<SpotifyAudioSegment>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as JukeboxAnalysis

        if (!sections.contentEquals(other.sections)) return false
        if (!bars.contentEquals(other.bars)) return false
        if (!beats.contentEquals(other.beats)) return false
        if (!tatums.contentEquals(other.tatums)) return false
        if (!segments.contentEquals(other.segments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sections.contentHashCode()
        result = 31 * result + bars.contentHashCode()
        result = 31 * result + beats.contentHashCode()
        result = 31 * result + tatums.contentHashCode()
        result = 31 * result + segments.contentHashCode()
        return result
    }
}

data class JukeboxSummary(
        val duration: Double
)