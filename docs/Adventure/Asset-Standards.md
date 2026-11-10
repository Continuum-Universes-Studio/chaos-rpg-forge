# Adventure Asset Standards

Adventure mode uses **64×64 pixels as the standard tile and sprite cell size** for new content.

The runtime remains data-driven: generated worlds read `tileSize` from `world/world.json`, and Tiled maps read `tilewidth`/`tileheight` from the map. This preserves compatibility with older 16×16 planes and maps while allowing new planes to be authored at 64×64.

## Generated-world terrain

Set the world tile size to 64:

```json
"tileSize": 64
```

Each terrain atlas region is an autotile sheet containing 3 columns by 4 rows. At the 64px standard, each terrain region is therefore **192×256 pixels**. The smaller transition pieces are derived from the same sheet by the runtime.

Use nearest-neighbor filtering for pixel art:

```text
filter: Nearest,Nearest
```

## World sprites and animated characters

New adventure-mode sprite frames should use 64×64 cells. Larger sprites are allowed when they intentionally occupy multiple cells; their position and collision bounds are still expressed in the map's pixel coordinate system.

## Tiled maps

New maps and tilesets should declare:

```xml
tilewidth="64" tileheight="64"
```

The Adventure Editor now starts new world tile-size fields at 64px and previews atlas entries at the standard cell size. Existing 16px content can remain in place and will continue to load according to its own map/world metadata.

## Compatibility rule

Do not change an existing 16px map's tile declarations merely to adopt the new art standard. Either keep that map legacy-compatible or migrate its tileset, map dimensions, object coordinates, collision geometry, and sprite assets together.
