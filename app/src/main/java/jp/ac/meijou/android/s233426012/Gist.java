package jp.ac.meijou.android.s233426012;

import java.util.Map;

/**
 * GistのJSONレスポンス
 */
public class Gist {
    public Map<String, GistFile> files;

    public static class GistFile {
        public String content;
    }
}