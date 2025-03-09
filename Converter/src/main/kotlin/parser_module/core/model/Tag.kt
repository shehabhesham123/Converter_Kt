package parser_module.core.model

/**
 *
 * This class serves as the base class for all platform-specific tags (e.g., HTML tags, XML tags).
 * It provides a common structure for tags, allowing them to be processed uniformly across different platforms.
 *
 * ### Usage Example:
 * ```kotlin
 * class HTMLTag : Tag() {
 *     // Platform-specific implementation
 * }
 * ```
 *
 * ### Key Responsibilities:
 * - Serve as a base class for platform-specific tag implementations.
 * - Provide a common type for tags in the parser module.
 *
 * ### Notes:
 * - Platform-specific implementations should extend this class to add additional
 *   properties or functionality as needed.
 * - This class is intentionally abstract to enforce inheritance and ensure that
 *   all tags are platform-specific.
 */
abstract class Tag