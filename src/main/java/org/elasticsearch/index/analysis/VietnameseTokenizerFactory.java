package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.vi.VietnameseTokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

public class VietnameseTokenizerFactory extends AbstractTokenizerFactory {

    private final boolean sentenceDetectorEnabled;
    private final boolean ambiguitiesResolved;

    public VietnameseTokenizerFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        sentenceDetectorEnabled = settings.getAsBoolean("sentence_detector", Boolean.FALSE);
        ambiguitiesResolved = settings.getAsBoolean("ambiguities_resolved", Boolean.FALSE);
    }

    @Override
    public Tokenizer create() {
        return new VietnameseTokenizer(sentenceDetectorEnabled, ambiguitiesResolved);
    }
}
