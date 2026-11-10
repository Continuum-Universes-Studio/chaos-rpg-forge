package forge.adventure.util;

/**
 * Shared dimensions for adventure-mode content.
 *
 * <p>Adventure mode uses pixel coordinates for its world units. New world and
 * map content should therefore use a 64x64 pixel tile and sprite cell. The
 * runtime still reads the dimensions of a loaded world or Tiled map so older
 * 16x16 content remains loadable.</p>
 */
public final class AdventureConstants {
    /** Standard cell size for new adventure-mode sprites and tilesets. */
    public static final int STANDARD_TILE_SIZE = 64;

    /** Cell size used by the original adventure content. */
    public static final int LEGACY_TILE_SIZE = 16;

    private AdventureConstants() {
    }

    /**
     * Returns a usable tile size for data written before the field existed.
     */
    public static int normalizeTileSize(int tileSize) {
        return tileSize > 0 ? tileSize : STANDARD_TILE_SIZE;
    }
}
