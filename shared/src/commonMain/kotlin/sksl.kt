import org.intellij.lang.annotations.Language

@Language("GLSL")
const val compositeSksl = """
                uniform float2 iResolution;      // Viewport resolution (pixels)
                uniform float  iTime;            // Shader playback time (s)

                vec4 main(in vec2 fragCoord) {
                // Skia板GLSLのコードである
                // main関数が存在し、引数としてfragCoordが渡される
                // 返り値としてgl_fragColorにセットするvec4を渡す
                
                vec2 st = fragCoord.xy / iResolution.xy;
                st.x *= iResolution.x / iResolution.y;
                
                vec3 color= vec3(0.0);
                float f = abs(sin(iTime) / 2) + 0.5;
                color = vec3(st.x, st.y, f);
                	return vec4( color, 1.0);
                }
            """

