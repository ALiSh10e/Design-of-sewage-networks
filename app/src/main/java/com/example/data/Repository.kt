package com.example.data

import android.content.Context
import com.example.engine.Pipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object Repository {
  private var dao: PipeDao? = null

  fun init(context: Context) {
    val db = AppDatabase.getInstance(context)
    dao = db.pipeDao()
  }

  fun getAll(): Flow<List<Pipe>> {
    val d = dao ?: throw IllegalStateException("Repository not initialized")
    return d.getAll().map { list -> list.map { e -> Pipe(e.id, e.length, e.diameter, e.slope, e.manningsN, e.hwCoeff) } }
  }

  suspend fun insert(pipe: Pipe) {
    val d = dao ?: throw IllegalStateException("Repository not initialized")
    d.insert(PipeEntity(pipe.id, pipe.length, pipe.diameter, pipe.slope, pipe.manningsN, pipe.hwCoeff))
  }

  suspend fun delete(pipe: Pipe) {
    val d = dao ?: throw IllegalStateException("Repository not initialized")
    d.delete(PipeEntity(pipe.id, pipe.length, pipe.diameter, pipe.slope, pipe.manningsN, pipe.hwCoeff))
  }

  suspend fun clear() {
    val d = dao ?: throw IllegalStateException("Repository not initialized")
    d.clear()
  }
}
