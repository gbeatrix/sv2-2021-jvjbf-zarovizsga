package videos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return List.copyOf(channels);
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getNumberOfVideos)
                .sum();
    }

    public void readDataFromFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                addChannel(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!", e);
        }
    }

    private void addChannel(String line) {
        String[] parts = line.split(";");
        String channelName = parts[0];
        int subscriptions = Integer.parseInt(parts[1]);
        int numberOfVideos = Integer.parseInt(parts[2]);
        channels.add(new Channel(channelName, subscriptions, numberOfVideos));
    }
}
