@GrpcService
public class SentimentServiceImpl extends SentimentServiceGrpc.SentimentServiceImplBase {

    private final Set<String> positiveWords = Set.of("good", "great", "excellent", "happy", "awesome");
    private final Set<String> negativeWords = Set.of("bad", "terrible", "poor", "sad", "awful");

    @Override
    public void analyzeSentiment(SentimentRequest request, StreamObserver<SentimentResponse> responseObserver) {
        String text = request.getText().toLowerCase();
        int positiveCount = 0;
        int negativeCount = 0;

        for (String word : positiveWords) {
            if (text.contains(word)) {
                positiveCount++;
            }
        }
        for (String word : negativeWords) {
            if (text.contains(word)) {
                negativeCount++;
            }
        }

        String sentiment;
        if (positiveCount > negativeCount) {
            sentiment = "positive";
        } else if (negativeCount > positiveCount) {
            sentiment = "negative";
        } else {
            sentiment = "neutral";
        }

        SentimentResponse response = SentimentResponse.newBuilder()
                .setSentiment(sentiment)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
