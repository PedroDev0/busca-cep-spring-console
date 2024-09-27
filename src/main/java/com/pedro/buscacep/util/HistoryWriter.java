package com.pedro.buscacep.util;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pedro.buscacep.environments.Environment;
import com.pedro.buscacep.model.History;
import com.pedro.buscacep.services.JsonService;

public class HistoryWriter {

	private List<History> historys = new ArrayList<>();
	private FileWriter fileWriter;
	private JsonService service;

	public HistoryWriter() {
		service = new JsonService();
		load();
	}

	public void load() {

		try {
			var jsonList = new String(Files.readAllBytes(Paths.get(Environment.FILE_HISTORY)));
			this.historys = service.jsonToList(jsonList, History.class);
		}catch (NoSuchFileException noFile) {
			writer();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void writer() {

		try {
			fileWriter = new FileWriter(Environment.FILE_HISTORY);
			fileWriter.write(service.listToStringJson(historys));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addHistory(History history) {

		this.historys.add(history);
	}

	public void close() throws IOException {

		writer();
		fileWriter.close();
	}

	public void listHistory() {

		AtomicInteger counter = new AtomicInteger(1);
		historys.forEach(t -> {
			System.out.println(counter.getAndIncrement() + " - " + t.toString());
		});
	}

}
